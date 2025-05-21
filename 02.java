 class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;


    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

     String getLicensePlate() {
        return licensePlate;
    }

   
    String getOwnerName() {
        return ownerName;
    }


     int getHoursParked() {
        return hoursParked;
    }

   
}

class ParkingLot{
	private Vehicle[] vehiarray=new Vehicle[5];
	private int vehicount=0;
	
	 public void addvehicle(Vehicle vehi){
		if(vehicount < vehiarray.length){
			vehiarray[vehicount]=vehi;
			vehicount++;
		}
		else{
			System.out.println("Parking Lot is full; can't add more vehicles");
		}
	}
	
	public void removevehicle(String licensePlate ){
		for(int i=0; i<vehicount;i++){
			if(vehiarray[i].getLicensePlate().equals(licensePlate)){
				for(int j=i;j<vehicount-1;j++){
					vehiarray[j]=vehiarray[j+1];
				}
				vehiarray[vehicount-1]=null;
				vehicount--;
				return;
			}
		}
		System.out.println("Licence Plate "+licensePlate+" is not founded");
	}
	public void display(){
        System.out.println("\nParking Lot Status:");
        System.out.println( "License Plate"+"  "+ "Owner"+"  "+ "Hours Parked");
		for(int i=0;i<vehicount;i++){
            Vehicle v = vehiarray[i];
            System.out.println( v.getLicensePlate()+"  "+ v.getOwnerName()+ "  " +v.getHoursParked());

		}
		if (vehicount==0){
			System.out.println("The Parking Lot is empty");
		}
	}
}

 class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot();


        parkingLot.addvehicle(new Vehicle("ABC123", "John Doe", 2));
        parkingLot.addvehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        parkingLot.addvehicle(new Vehicle("LMN456", "Bob Brown", 1));

        parkingLot.display();

        parkingLot.removevehicle("XYZ789");
        parkingLot.display();
    }
}