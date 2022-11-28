package Troca_Marcha;

public class Veiculo {

		
		String numberOfChassi;
		double maxVelocity;
		double kilometerDriven;
		double horsePower;
		String color;
		int numberOfDoors;
		double velocity;
		int gear;
		boolean on;
		
		Veiculo(){}
		
		Veiculo(String numberOfChassi, String color){
			this.numberOfChassi = numberOfChassi;
			velocity = 0;
			maxVelocity = 180;
			kilometerDriven = 0;
			horsePower = 80;
			this.color = color;
			numberOfDoors = 4;
			gear = 0;
			on = false;
		}
		
		void turnOn() {
			on = true;
		}
		
		void turnOff() {
			on = false;
		}
		
		void accelerate() {
			if(gearRule()) {
				velocity+=5;
			}
		}
		
		void brake() {
			if(velocity > 0) {
				velocity -= 5;
			}
		}
		
		void rotateSteeringWheel() {}
		
		void downShift() {
			if(gear > 0) {
				gear--;
			}
		}
		
		void upShift() {
			int maxGear = 5;
			if(gear <= maxGear) {
				gear++;
			}
		}
		
		boolean gearRule() {
			if(gear == 1 && velocity <= 20) {
				return true;
			} else if(gear == 2 && velocity < 30) {
				return true;
			} else if(gear == 3 && velocity < 40) {
				return true;
			} else if(gear == 4 && velocity < 65) {
				return true;
			} else return gear == 5 && velocity <= maxVelocity;
		}
	}
