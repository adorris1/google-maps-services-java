package connections;


import java.sql.*;

public class customer {

	private String firstName;
	private String lastName;
	private String addrLineOne;
	private String addrLineTwo;
	private String city;
	private String state;
	private String zip;
	private String phoneNum;
	protected int CID;
	protected int PID;
	protected String publicationName;
	private String status;
	private subscriptions mySubs;
	private LatLng myPoints;
	private connect cn = new connect();

	// create new customer AddTypeOne
	public customer(connect con, String fN, String lN, String addLn1, String c, String st, String z, String pN) {
		cn = con;
		cn.addCustomer(fN, lN, addLn1, "", c, st, z, pN);
		CID = cn.getCustomerID(pN);
		myPoints = new LatLng(cn, CID, z, addLn1, st);
		status = "ACTIVE";
		firstName = fN;
		lastName = lN;
		addrLineOne = addLn1;
		addrLineTwo = null;
		city = c;
		state = st;
		zip = z;
		phoneNum = pN;
	}

	// create new customer AddTypeTwo
	public customer(connect con, String fN, String lN, String addLn1, String addLn2, String c, String st, String z, String pN) {
		cn = con;
		cn.addCustomer(fN, lN, addLn1, addLn2, c, st, z, pN);
		CID = cn.getCustomerID(pN);
		myPoints = new LatLng(cn, CID);
		// mySubs = new subscriptions (cn, CID, pubID);
		status = "ACTIVE";
		firstName = fN;
		lastName = lN;
		addrLineOne = addLn1;
		addrLineTwo = null;
		city = c;
		state = st;
		zip = z;
		phoneNum = pN;
	}

	
	// select customer with specified customer ID
	public customer(connect con, int ID) {
		cn = con;
		ResultSet r = cn.searchCustomer(ID, "", "");
		try {
			while (r.next()) {
				CID = r.getInt("CustomerID");
				status = r.getString("Status");
				firstName = r.getString("FirstName");
				lastName = r.getString("LastName");
				addrLineOne = r.getString("Address");
				if ((addrLineTwo = r.getString("AddressLineTwo")).length() == 0)
					addrLineTwo = null;
				city = r.getString("City");
				state = r.getString("State");
				zip = r.getString("Zip");
				phoneNum = r.getString("Phone");
			}
			r.close();
			ResultSet points = cn.getLatLngValues(ID);
			while(points.next()){
				myPoints = new LatLng(points.getDouble("Latitude"), points.getDouble("Longitude"));
			}
			points.close();
		} catch (Exception e) {
			CID = 0;
		}
	}
	
	//this constructor creates a customer object strictly for the printing function. Only necessary information is initialized to values
	public customer(int ID, String fN, String lN, String addLn1, String addLn2, String c, String s, String z){
		CID = ID;
		firstName = fN;
		lastName = lN;
		addrLineOne = addLn1;
		addrLineTwo = addLn2;
		city =c;
		state = s;
		zip = z;
	}

	public LatLng getLatLng() {
		return myPoints;
	}

	public subscriptions getMySubscriptions() {
		return mySubs;
	}

	public String toString() {
		if (addrLineTwo != null) {
			return "Customer ID: " + CID + "\nName: " + firstName + " " + lastName + "\nAddress: " + addrLineOne + "\n"
					+ addrLineTwo + "\n" + city + ", " + state + " " + zip + "\nPhone Number: " + phoneNum
					+ "\nStatus: " + status;}

		else {
			return "Customer ID: " + CID + "\nName: " + firstName + " " + lastName + "\nAddress: " + addrLineOne + "\n"
					+ city + ", " + state + " " + zip + "\nPhone Number: " + phoneNum + "\nStatus: " + status;
		}
	}

	public boolean modFirstName(String fN) {
		firstName = fN;
		return cn.modCustomerInfo(CID, "FirstName", fN);
	}

	public boolean modLastName(String lN) {
		lastName = lN;
		return cn.modCustomerInfo(CID, "LastName", lN);
	}

	public boolean modAddress(String addLn1, String c, String s, String z){
        addrLineOne = addLn1;
        city = c;
        state = s;
        zip = z;
        if(cn.modCustomerInfo(CID, "Address", addLn1)&&cn.modCustomerInfo(CID, "City", c)&&cn.modCustomerInfo(CID, "State", s)&&cn.modCustomerInfo(CID, "Zip", z)){
 
            return true;
        }
        else
            return false;
    }
    
    public boolean modAddress(String addLn1, String addLn2, String c, String s, String z){
        addrLineOne = addLn1;
        addrLineTwo = addLn2;
        city = c;
        state = s;
        zip = z;
        if(cn.modCustomerInfo(CID, "Address", addLn1)&&cn.modCustomerInfo(CID, "AddressLineTwo", addLn2)&&cn.modCustomerInfo(CID, "City", c)&&cn.modCustomerInfo(CID, "State", s)&&cn.modCustomerInfo(CID, "Zip", z)){
 
 
            return true;
        }
        else
            return false;
    }
	public boolean modPhoneNum(String pN) {
		phoneNum = pN;
		return cn.modCustomerInfo(CID, "Phone", pN);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public int getCustID() {
		return CID;
	}

	 public boolean setStatus(String st){
	        if(status.equals(st)){
	            return false;
	        }
	        else{
	            status = st;
	            return cn.modCustomerInfo(CID, "Status", st);
	        }//gg
	    }
	    
	    public String getFullName(){
	        return firstName + " " + lastName;
	    }
	    
	    public String getAddress(){
	        if(addrLineTwo!=null){
	            return String.format("%s%n%s%n%s, %s %s", addrLineOne, addrLineTwo, city, state, zip);
	        }
	        else{
	        	return String.format("%s%n%s, %s %s", addrLineOne, city, state, zip);
	        }
	    }
	    
	    //for use without creating a customer object
	    public static String getAddress(String addLn1, String addLn2, String c, String s, String z){
	        if(addLn2!=null&&addLn2!=""){
	            return String.format("%s%n%s%n%s, %s %s", addLn1, addLn2, c, s, z);
	        }
	        else{
	            return String.format("%s%n%s, %s %s", addLn1, c, s, z);
	        }
	    }
	    
	    public int getCID(){
	        return CID;
	    }
	}