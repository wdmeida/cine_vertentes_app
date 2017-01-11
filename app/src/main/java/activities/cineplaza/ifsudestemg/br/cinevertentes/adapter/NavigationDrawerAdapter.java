package activities.cineplaza.ifsudestemg.br.cinevertentes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import activities.cineplaza.ifsudestemg.br.cinevertentes.R;
import activities.cineplaza.ifsudestemg.br.cinevertentes.model.NavDrawerItem;

/**
 * Classe responsável por processar o XML de personalização do RecyclerView
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder>{
    List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }//NavigationDrawerAdapter

    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }//delete()

    //Infla o componente do menu para que possa ser manipulado pelo RecyclerView.
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }//onCreateViewHolder

    //Obtém a posição de cada elemento do menu, registra e define seu label.
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());
    }//onBindViewHolder()

    @Override
    public int getItemCount() {
        return data.size();
    }//getItemCount()

    //Classe interna responsável por obter a referência dos itens do RecyclerView
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
        }
    }//class MyViewHolder
}//class NavigationDrawerAdapter
