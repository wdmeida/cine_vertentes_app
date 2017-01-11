package activities.cineplaza.ifsudestemg.br.cinevertentes.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import java.util.List;

import activities.cineplaza.ifsudestemg.br.cinevertentes.R;
import activities.cineplaza.ifsudestemg.br.cinevertentes.model.Movie;

/**
 * Created by wagner on 07/09/16.
 */
public class MoviesAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Movie> movies;
    private ImageLoader mImageLoader;

    //Construtor default.
    public MoviesAdapter(Context context, List<Movie> movies, ImageLoader mImageLoader) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.movies = movies;
        this.mImageLoader = mImageLoader;
    }

    //Deve definir o tamanho da lista.
    @Override
    public int getCount() {
        return movies.size();
    }

    //Obtém um objeto da lista através de sua posição.
    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    //Como foi não foi definido nenhum id, será retornada a posição do item.
    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
        O método getView() é o mais importante, pois será chamado para cada item da lista. Ele é responsável
        por definir os atributos do nosso listView e exibi-los na tela..
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
        /*
            O layoutInflater transforma o layout xml em um objeto para que possamos acessar
            seus componentes como metodos..
        */
            convertView = inflater.inflate(R.layout.item, null);
            viewHolder = new ViewHolder();
            convertView.setTag(viewHolder);

            //Obtém as referências dos componentes das views.
            viewHolder.coverMovie = (ImageView) convertView.findViewById(R.id.image_movie);
            viewHolder.nameMovie = (TextView) convertView.findViewById(R.id.name_movie);
            viewHolder.genreMovie = (TextView) convertView.findViewById(R.id.genre_movie);
            viewHolder.exibitionMovie = (TextView) convertView.findViewById(R.id.movie_hour);
            viewHolder.durationMovie = (TextView) convertView.findViewById(R.id.duration_movie);
            viewHolder.classificationMovie = (TextView) convertView.findViewById(R.id.classification_movie);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameMovie.setText(movies.get(position).getName());
        viewHolder.genreMovie.setText("Gênero: " + movies.get(position).getGenre());
        viewHolder.classificationMovie.setText("Classificação: " + movies.get(position).getClassification());
        viewHolder.durationMovie.setText("Duração: " + movies.get(position).getDuration());
        viewHolder.exibitionMovie.setText("Exibição: " + movies.get(position).getExibition());

        //Image Loader
        mImageLoader.displayImage(
                                  movies.get(position).getCover(), //Url da imagem a ser carregada.
                                  viewHolder.coverMovie, //View onde ela será usada.
                                  null,
                                    //Implementação da classe ImageLoadingListener, onde devem ser realizadas ações em etapas do carregamento das imagens.
                                  new ImageLoadingListener() {

                                    @Override
                                    public void onLoadingStarted(String url, View view) {
                                        Log.i("Script", "onLoadingStarted()");
                                    }

                                    @Override
                                    public void onLoadingFailed(String url, View view, FailReason failReason) {
                                        Log.i("Script", "onLoadingFailed()");
                                    }

                                    @Override
                                    public void onLoadingComplete(String url, View view, Bitmap bitmap) {
                                        Log.i("Script", "onLoadingComplete()");
                                    }

                                    @Override
                                    public void onLoadingCancelled(String url, View view) {
                                        Log.i("Script", "onLoadingCancelled()");
                                    }
                                },
                                //Implementação da classe ImageLoadingProgressListener, que informa o progresso carregamento das imagens.
                               new ImageLoadingProgressListener() {
                                    @Override
                                    public void onProgressUpdate(String uri, View view, int current, int total) {
                                        Log.i("Script", "onProgressUpdade(" + uri + " - " + current + " - " + total +" )");
                                    }
                                });

        return convertView;
    }

    private class ViewHolder{
        public ImageView coverMovie;
        public TextView nameMovie;
        public TextView genreMovie;
        public TextView exibitionMovie;
        public TextView classificationMovie;
        public TextView durationMovie;
    }
}
