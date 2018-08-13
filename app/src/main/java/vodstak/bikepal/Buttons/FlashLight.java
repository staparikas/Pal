package vodstak.bikepal.Buttons;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;


public class FlashLight {
    private Boolean isOn = false;
    private CameraManager manager;
    private String cameraId;

    private Context context;


    public FlashLight(Context context) {

        this.context = context;


        manager = (CameraManager) this.context.getSystemService(Context.CAMERA_SERVICE);

        try {
            cameraId = manager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }


    }

    public void flash() {

        if (!isOn) {


            isOn = true;
            turnOnFlashLight();

        } else {


            isOn = false;
            turnOffFlashLight();

        }

    }

    public void turnOnFlashLight() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                manager.setTorchMode(cameraId, true);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void turnOffFlashLight() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                manager.setTorchMode(cameraId, false);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

}

