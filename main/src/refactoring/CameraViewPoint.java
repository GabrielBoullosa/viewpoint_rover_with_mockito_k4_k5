package refactoring;

public class CameraViewPoint implements ViewPoint{
    private int angle;
    private Camera camera;
    private ImageProcessor ImageProcessor;

    public CameraViewPoint(int angle, Camera camera, refactoring.ImageProcessor imageProcessor) {
        this.angle = angle;
        this.camera = camera;
        ImageProcessor = imageProcessor;
    }

    public int angle() {
        return angle;
    }

    public void angleChange(int angle) {
        this.angle += angle;
    }

    @Override
    public ViewPoint forward() {
        return this;
    }

    @Override
    public ViewPoint backward() {
        return this;
    }

    @Override
    public ViewPoint turnLeft(){
        angleChange(90);
        return this;
    }

    @Override
    public ViewPoint turnRight() {
        angleChange(-90);
        return this;
    }


}
