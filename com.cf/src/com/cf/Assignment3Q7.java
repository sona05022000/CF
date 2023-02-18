package com.cf;
class ParkingSlot {
    private String ownerName;
    private int carNumber;
    private int token;
    private int level;
    private int section;
    private int slot;
	public ParkingSlot(String ownerName, int carNumber, int token, int level, int section, int slot) {
		super();
		this.ownerName = ownerName;
		this.carNumber = carNumber;
		this.token = token;
		this.level = level;
		this.section = section;
		this.slot = slot;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
    
}

class Parked_CarOwenerList {
	private ParkingSlot[][][] parkingslots;
    int levels = 3;
    int sections = 4;
    int slots = 20;
    
        public Parked_CarOwenerList( int levels, int sections, int slots) {
		super();
		parkingslots=new ParkingSlot[levels][sections][slots];
		for(int i=0;i<levels;i++) {
			for(int j=0;j<sections;j++) {
				for(int k=0;k<slots;k++) {
					parkingslots[i][j][k]=null;
				}
			}
		}
        }
		public int add_new_car(Assignment3Q7 owner1){
			for (int i = 0; i < parkingslots.length; i++) {
    for (int j = 0; j < parkingslots[i].length; j++) {
        for (int k = 0; k < parkingslots[i][j].length; k++) {
            if (parkingslots[i][j][k] == null) {
                ParkingSlot slot = new ParkingSlot("John",0403,1234,3,4,20);
                slot.setOwnerName(owner1.getName());
                slot.setCarNumber(owner1.getCarNo());
                slot.setToken(generateToken());
                slot.setLevel(i + 1);
                slot.setSection(j + 1);
                slot.setSlot(k + 1);
                parkingslots[i][j][k] = slot;
                return slot.getToken();
                
            }
        }
    }
}
 return -1;// Parking full
}

		
		
    private int generateToken() {
			// TODO Auto-generated method stub
			return (int) (Math.random()*1000)+1;
		}
	public void remove_car(String name,int carNo){
    	for (int i = 0; i < parkingslots.length; i++) {
            for (int j = 0; j < parkingslots[i].length; j++) {
                for (int k=0;k<parkingslots[i][j].length;k++) {
                	if (parkingslots[i][j][k] != null && parkingslots[i][j][k].getOwnerName().equals(name) && parkingslots[i][j][k].getCarNumber() == carNo) {
                        parkingslots[i][j][k] = null;
                        return;
                }
                }
            }
    	}
    	
    }
     public String getparkedcarlocation(int token){
    	for (int i = 0; i < parkingslots.length; i++) {
            for (int j = 0; j < parkingslots[i].length; j++) {
                for (int k = 0; k < parkingslots[i][j].length; k++) {
                    if (parkingslots[i][j][k] != null && parkingslots[i][j][k].getToken() == token) {
                        return "Level: " + (i + 1) + ", Section: " + (j + 1) + ", Slot: " + (k + 1);
                    }
                }
            }
        }
        return "Invalid Token";
    	
    }
	}


public class Assignment3Q7 {
	private String name;
    private String carModel;
    private int carNo;
    private int mobileNumber;
    private String address;


    public Assignment3Q7(String name, String carModel, int carNo, int mobileNumber, String address) {
		super();
		this.name = name;
		this.carModel = carModel;
		this.carNo = carNo;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCarModel() {
		return carModel;
	}


	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}


	public int getCarNo() {
		return carNo;
	}


	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}


	public int getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public static void main(String[] args) {
		Parked_CarOwenerList list=new Parked_CarOwenerList(3,4,20);
		Assignment3Q7 owner1=new Assignment3Q7("John","Toyota",1234,810221,"123 main st");
		int token1=list.add_new_car(owner1);
		System.out.println("Car parked at token"+" " + token1);
		Assignment3Q7 owner2=new Assignment3Q7("Jane","Honda",1204,810721,"456 main st");
		int token2=list.add_new_car(owner1);
		System.out.println("car parked at token"+" "+token2);
		String location1=list.getparkedcarlocation(token1);
		System.out.println("car with token"+ " " +token1+" "+"is parked at"+ " "+location1);
		list.remove_car("John", 1234);
		String location2=list.getparkedcarlocation(token1);
		System.out.println("car with token"+ " " +token1+ " " +"is parked at"+ " " +location2);
		
			
		}


	}