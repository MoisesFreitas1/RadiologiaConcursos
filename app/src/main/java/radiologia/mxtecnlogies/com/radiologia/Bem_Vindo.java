package radiologia.mxtecnlogies.com.radiologia;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Moisés on 10/02/2016.
 */
public class Bem_Vindo extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bem_vindo, container, false);
        return view;
    }
}
