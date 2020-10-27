package ibrahim.ali.s301022172;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class IbrahimFragment extends Fragment{

    private CanvasView customCanvas;
    RadioButton black, green, red;
    RadioButton size10, size20, size30;
    String paint,brush;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ibrahim, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);

        textView.setText("Ibrahim Ali 301022172");

        clearCanvas(root);

        return root;
    }

    public void clearCanvas(final View view){
        customCanvas = (CanvasView) view.findViewById(R.id.ibrahimCanvas);

        final Button btnClearCanvas = view.findViewById(R.id.ibrahimClearCanvasBtn);
        btnClearCanvas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                customCanvas.clearPath();
            }
        });
    }

    public void selectPaintBrush(final View view){ }
}