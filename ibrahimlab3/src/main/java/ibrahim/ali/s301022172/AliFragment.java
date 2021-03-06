/**
 * Full Name: Ibrahim Ali
 * Student ID: 301022172
 * Section: COMP 304 - 002
 * */
package ibrahim.ali.s301022172;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class AliFragment extends Fragment {
    //Declare variables
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    Intent intent;
    Button btnPhoneCall;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ali, container, false);

        //Btns onClick event
        btnPhoneCall = (Button) root.findViewById(R.id.ibrahimPhoneInsertBtn);
        btnPhoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkPhoneCallPermission();
            }
        });

        return root;
    }

    //checkPhoneCallPermission function
    private void checkPhoneCallPermission() {
        int hasWriteContactsPermission = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            hasWriteContactsPermission = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CALL_PHONE);

            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }

        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(647)286-4816"));
        startActivity(intent);
    }

    public void selectSpeed(View view){ }

    public void stopAnimation(View view){ }
}