import java.awt.*;

public class Car implements Movable{

    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName; // The car model name
    double xPosition; // X position of the car
    double yPosition; // Y position of the car
    Direction direction; // Direction the car is facing

    public Car() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Generic Car";
        xPosition = 0;
        yPosition = 0;
        direction = Direction.NORTH;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    String getModelname() {
        return modelName;
    }

    public void setColor(Color clr) {
	    color = clr;
    }

    public void startEngine() {
	    currentSpeed = 0.1;
    }

    public void stopEngine() {
	    currentSpeed = 0;
    }

    protected double speedFactor() {
        return enginePower * 0.01;
    }

    protected void incrementSpeed(double amount) {
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    protected void gas(double amount) {
        if (amount > 1 || amount < 0) {
            System.out.println("Amount must be between 0 and 1");
            return;
        }
        incrementSpeed(amount);
    }

    protected void brake(double amount) {
        if (amount > 1 || amount < 0) {
            System.out.println("Amount must be between 0 and 1");
            return;
        }
        decrementSpeed(amount);
    }

    @Override
    private void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    private void turnLeft() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turnLeft'");
    }

    @Override
    private void turnRight() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turnRight'");
    }    

}