package refactoring;

public class Camera {
    private CameraView frontView;
    private CameraView rearView;
    private int angle;

    public void turnLeft(int angle) {
        this.angle += angle;
    }

    public void turnRight(int angle) {
        this.angle -= angle;
    }
}
