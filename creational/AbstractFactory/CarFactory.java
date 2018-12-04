public class CarFactory
{
  private CarFactory() {
    //Prevent instantiation
  }
 
  public static Car buildCar(CarType type)
  {
    Car car = null;
    Location location = Location.ASIA; //Read location property somewhere from configuration
    //Use location specific car factory
    switch(location)
    {
      case USA:
        car = USACarFactory.buildCar(type);
        break;
      case ASIA:
        car = AsiaCarFactory.buildCar(type);
        break;
      default:
        car = DefaultCarFactory.buildCar(type);
    }
  return car;
  }
}

public class TestFactoryPattern {
    public static void main(String[] args) {
        System.out.println(CarFactory.buildCar(CarType.SMALL));
        System.out.println(CarFactory.buildCar(CarType.SEDAN));
        System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }
}