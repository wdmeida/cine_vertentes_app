package activities.cineplaza.ifsudestemg.br.cinevertentes.controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Classe responsável por verificar se o dispositivo possui acesso à internet.
public class ConnectionStatus {
    private Context context;

    public ConnectionStatus(Context context) {
        this.context = context;
    }

    public boolean isConnected() {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (manager != null) {
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();

            // Caso não exista nenhum tipo de conexão retorna false.
            if (networkInfo == null) return false;

            // Obtêm o tipo de conexão.
            int netType = networkInfo.getType();

            // Verifica se a conexão é do tipo WiFi ouo Moble e retorna true se estiver conectado ou false caso contrário.
            if (netType == ConnectivityManager.TYPE_VPN || netType == ConnectivityManager.TYPE_MOBILE) return networkInfo.isConnected();
            else return false;
        }
        return false;
    }//isOnline
}//class ConnectionStatus
