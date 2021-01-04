package in.srini91.learn.aop.introductions;

public class FlyerImpl implements Flyer, Flyer2 {

	@Override
	public void takeOff() {

		System.out.println("Take Off the plane!!!");
	}

	@Override
	public void fly() {
		System.out.println("Fly the plane!!!");

	}

	@Override
	public void land() {
		System.out.println("Land the plane!!!");

	}

	@Override
	public void roll() {
		System.out.println("Roll the plane!!!");

	}

	public void execute() {
		takeOff();
		fly();
		roll();
		land();

	}

}
