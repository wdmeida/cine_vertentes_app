package activities.cineplaza.ifsudestemg.br.cineplazaapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;

import java.util.List;

import activities.cineplaza.ifsudestemg.br.cineplazaapp.R;
import activities.cineplaza.ifsudestemg.br.cineplazaapp.adapter.MoviesAdapter;
import activities.cineplaza.ifsudestemg.br.cineplazaapp.constants.Constants;
import activities.cineplaza.ifsudestemg.br.cineplazaapp.controller.ProcessResponseJSON;
import activities.cineplaza.ifsudestemg.br.cineplazaapp.controller.RequestTask;
import activities.cineplaza.ifsudestemg.br.cineplazaapp.dao.MovieDAO;
import activities.cineplaza.ifsudestemg.br.cineplazaapp.model.Movie;
import butterknife.ButterKnife;

public class ListaFilmesActivity extends AppCompatActivity {
    private List<Movie> movies;
    private ListView listMovies;
    private TextView weekTextView;
    private ImageLoader mImageLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        //Associa a classe que o ButterKnife associará as Views.
        ButterKnife.bind(this);
        initComponentsActivity();
    }//onCreate()

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Limpa a memória para evitar estouro da mesma e problemas de segurança.
        mImageLoader.clearMemoryCache();
        mImageLoader.stop();
    }

    //Obtêm as referências dos componentes que serão utilizados da activity e define as configurações da mesma.
    private void initComponentsActivity(){

        weekTextView = (TextView) findViewById(R.id.week_movies);
        try {
            RequestTask requestTask = new RequestTask();
            String respost = requestTask.execute(Constants.URL_API_CINE_PLAZA).get();
            ProcessResponseJSON processResponseJSON = new ProcessResponseJSON(respost);
            if(processResponseJSON.isValidRespost()){
                //Obtém a lista de filmes e a semana da programação.
                movies = processResponseJSON.getAllMovies();
                weekTextView.setText("Semana de" + processResponseJSON.getWeekProgramation());
                saveAllMoviesDatabase(movies);
            }
        } catch (Exception e) {
            e.printStackTrace();
            movies = new MovieDAO(ListaFilmesActivity.this).getAll();
            weekTextView.setText("Semana de" + movies.get(0).getWeek());
        }



        //Define as configurações do ImageLoader, responsável por gerenciar o download e exibição das imagens.
        mImageLoader = ImageLoader.getInstance();
        mImageLoader.init(getConfImageLoader());

        /*
            Define um objeto responsável por controlar a execução das Threads ao se utilizar o scrol da tela.
            Os parâmetros recebidos são, o ImageLoader responsável por carregar as imagens, um boolean que
            informa se desejamos pausar o carregamento da imagem caso o usuário utilize o scroll da tela e o
            terceiro parâmetro é um boolean que informa se desejamos descartar as threads pausadas.
         */
        PauseOnScrollListener mPauseOnScrollListener = new PauseOnScrollListener(mImageLoader, true, true);

        listMovies = (ListView) findViewById(R.id.list_movies);
        listMovies.setAdapter(new MoviesAdapter(ListaFilmesActivity.this, movies, mImageLoader));
        listMovies.setOnScrollListener(mPauseOnScrollListener);

        //Define o ouvinte do listener dos itens da listView.
        listMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                try {
                    Movie m = (Movie) adapterView.getItemAtPosition(position);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(m.getTrailer())));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("Erro", "Erro ao acessar o Youtube");
                }
            }
        });
    }//initComponentsActivity()

    //Salva as informações no banco de dados.
    private void saveAllMoviesDatabase(List<Movie> movies){
        MovieDAO movieDAO = new MovieDAO(ListaFilmesActivity.this);
        //Apaga o banco antigo. ********* Modificar depois.
        movieDAO.deleteAll();

        for (Movie m: movies) movieDAO.insert(m);
    }

    //Define as configurações do ImageLoaderConfiguration para processar o download as imagens da aplicação.
    private ImageLoaderConfiguration getConfImageLoader(){

        //Objeto onde serão armazenados as configurações de armazenamento, local do cache, exibição, dentre outras opções.
        DisplayImageOptions mDisplayImageOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.not_cover_movie) //Imagem não encontrada
                .showImageOnFail(R.drawable.not_cover_movie) //Falhar no carregamento da imagem
                .showImageOnLoading(R.drawable.not_cover_movie) //Imagem sendo carregada.
                .cacheInMemory(true) //Ativa o cache em memória.
                .cacheOnDisk(true) //Ativa o cache em disco.
                // .displayer(new FadeInBitmapDisplayer(1000))  //Transição de exibição da imagem.
                .build();

        //Configurações durante o carregamento das imagens.
        ImageLoaderConfiguration conf = new ImageLoaderConfiguration.Builder(ListaFilmesActivity.this)
                .defaultDisplayImageOptions(mDisplayImageOptions)
                .memoryCacheSize(5 * 1024 * 1024) //Tamanho do cache em memória (5 MB).
                .diskCacheSize(5 * 1024 * 1024)  //Tamanhao máximo do cache (5 MB).
                .threadPoolSize(5)  //Quantidade de threads a serem utilizadas.
                .writeDebugLogs()
                .build();

        return conf;
    }//getConfImageLoader()
}//class ListarFilmesActivity
