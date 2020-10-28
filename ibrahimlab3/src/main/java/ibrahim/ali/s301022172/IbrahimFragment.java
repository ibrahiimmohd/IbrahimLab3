/**
 * Full Name: Ibrahim Ali
 * Student ID: 301022172
 * Section: COMP 304 - 002
 * */
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

    //Declare variables
    private CanvasView customCanvas;
    RadioButton black, green, red;
    RadioButton size10, size20, size30;
    String paint,brush;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Declare and initialize variables
        View root = inflater.inflate(R.layout.fragment_ibrahim, container, false);
        final TextView tv = root.findViewById(R.id.ibrahimTextIbraFragment);

        //set tv variable text
        tv.setText("Ibrahim Ali 301022172");

        //Call clear canvas function
        clearCanvas(root);

        return root;
    }

    //Clear canvas function
    public void clearCanvas(final View view){
        //Initialize variables
        customCanvas = (CanvasView) view.findViewById(R.id.ibrahimCanvas);
        final Button btnClearCanvas = view.findViewById(R.id.ibrahimClearCanvasBtn);

        //Setting onClick event listener
        btnClearCanvas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                customCanvas.clearPath();
            }
        });
    }

    public void selectPaintBrush(final View view){ }
}