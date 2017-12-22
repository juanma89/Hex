package vision.google.com.criper3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Base64;

public class MainActivity extends AppCompatActivity {

    public TextView tx; //Texto Plano
    public TextView b64; //Texto Plano a Base64
    public TextView mb64; //Base64 menos su primer caractér
    public TextView h64; //Base64 a Bytes (hexadecimal
    public TextView de64;
    public Button btn; //Botón para desencriptar

    static final String HEXES = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se inicializa el botón
        Button btndesencriptar = findViewById(R.id.btn_desencriptar);
        btndesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View view) {

                tx = findViewById(R.id.textView_textoplano);
                b64 = findViewById(R.id.textView2_base64);
                mb64 = findViewById(R.id.textView3_menosbase64);
                h64 = findViewById(R.id.textView4_hexadecimal);
                de64 = findViewById(R.id.textView_deco);

                //Obtenemos la cadena en texto plano
                //*******String cdnatxtplano = "C4ahGgCf+ALg75FXkqqS3NvoTgegr43efwQ3X9hM+ioC9nchYunaR5l9gFNTXYNIb+b+Xk6sjiiAmSYbA/FFqjkleAzjSmXCMsvhzYdSw3tVxoXzFBYtI9E5/1WhXBeQ+";
                //*******tx.setText(cdnatxtplano);
                //Convertimos a Base 64
                //*******String cdnabase64 = new String(Base64.encodeToString(cdnatxtplano.getBytes(),Base64.NO_WRAP));
                String cdnabase64 = "C4ahGgCf+ALg75FXkqqS3NvoTgegr43efwQ3X9hM+ioC9nchYunaR5l9gFNTXYNIb+b+Xk6sjiiAmSYbA/FFqjkleAzjSmXCMsvhzYdSw3tVxoXzFBYtI9E5/1WhXBeQ+";
                //Mostramos la cadena en base64
                b64.setText(cdnabase64);
                //Quitamos el primer caractér a la cadena en base64
                String cdnacorta = cdnabase64.substring(1,cdnabase64.length());
                //Mostramos la cadena base64 sin el primer caractér
                mb64.setText(cdnacorta);
                //Pasamos a hexadecimal

                byte[] bufalo = cdnacorta.getBytes();//
                StringBuffer sb = new StringBuffer();//
                for(byte b: bufalo){                 //   ESTO DEBE SER CAMBIADO. PUES NOS
                    sb.append(String.format("%2x",b));//    DEVUELVE UNA CADENA EN HEX
                }                                    //     QUE NO DEBERÍA DE SER
                h64.setText(sb); //Muestra la cadena en HEXADECIMAL, PERO NO NOS FUNCIONA :(
            }
        });
    }
//    public static  String getHex (byte[] raw){
//        if (raw == null){
//            return null;
//        }
//        final StringBuilder hex = new StringBuilder(2 * raw.length);
//        for(final byte b : raw){
//        hex.append(HEXES.charAt((b & 0xF0)>>4));
//        hex.append(HEXES.charAt((b & 0xF0)));
//        }
//        return hex.toString();
//    }
}