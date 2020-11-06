package refactoring;

public class SimpleViewPoint implements ViewPoint {
    private Position position;
    private Heading heading;

    public SimpleViewPoint(String facing, int x, int y){
        heading = Heading.of(facing);
        position = new Position(x, y);

    }

    public SimpleViewPoint(Heading heading, int x, int y){
        this.heading = heading;
        position = new Position(x, y);
    }

    public SimpleViewPoint(Heading heading, Position position) {
        this.heading = heading;
        this.position = position;
    }

    @Override
    public void forward() {
        position = position.forward(heading);
    }

    @Override
    public void backward() {
        position = position.backward(heading);
    }

    @Override
    public void turnLeft() {
        heading = heading.turnLeft();
    }

    @Override
    public void turnRight() {
        heading = heading.turnRight();
    }

    public Position position() {
        return position;
    }

    public Heading heading() {
        return heading;
    }
}
