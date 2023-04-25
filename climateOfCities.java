public class City {
	private String name;
	private String state;
	private double highTemp;
	private double lowTemp;
	
	public City(String name, String state, double highTemp, double lowTemp) {
		this.name = name;
		this.state = state;
		this.highTemp = highTemp;
		this.lowTemp = lowTemp;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getState() {
		return this.state;
	}
	
	public double getHighTemp() {
		return this.highTemp;
	}
	
	public double getLowTemp() {
		return this.lowTemp;
	}
	
	public void setHighTemp(double newTemp) {
		this.highTemp = newTemp;
	}
	
	public void setLowTemp(double newTemp) {
		this.lowTemp = newTemp;
	}
	
	public void printInfo() {
		System.out.printf("%s, %s (High = %.2f, Low = %.2f)\n", this.name, this.state, this.highTemp, this.lowTemp);
	}
}

import java.io.*;
import java.util.*;
public class ClimateZone {
	private ArrayList<City> cityList;
	
	public ClimateZone() {
		 cityList = new ArrayList<City>();
	}
	
	public ClimateZone(String ClimateFile) throws IOException {
		cityList = new ArrayList<City>();
	    File file = new File(ClimateFile);
	    Scanner fileReader = new Scanner(file);
	    while(fileReader.hasNext()) {
	    	String name = fileReader.next();
	    	String state = fileReader.next();
	    	double highTemp = fileReader.nextDouble();
	    	double lowTemp = fileReader.nextDouble();
	    	
	    	this.addCity(name, state, highTemp, lowTemp);
	    }
	    
	    fileReader.close();
		
	}
	
	public void addCity(String name, String state, double highTemp, double lowTemp) {
		City newCity = new City(name, state, highTemp, lowTemp);
		cityList.add(newCity);
	}
	
	public int getCityCount() {
		return cityList.size();
	}
	
	public City getCityByName(String name, String state) {
		for(City city : cityList) {
			if(city.getName().equals(name) && city.getState().equals(state)) {
				return city;
			}
		}
		return null;
	}
	
	public void printHottestCities() {
		City firstHottest = null;
		City nextHottest = null;
		double hottestTemp = 0;
		
//		FIND FIRST HOTTEST
		for(City curCity : cityList) {
			if(curCity.getHighTemp() > hottestTemp ) {
				firstHottest = curCity;
				hottestTemp = curCity.getHighTemp();
			}
		}
		hottestTemp = 0;
//		FIND SECOND HOTTEST
		for(City curCity : cityList) {
			if(curCity.getHighTemp() > hottestTemp && (curCity != firstHottest)) {
				nextHottest = curCity;
				hottestTemp = curCity.getHighTemp();
			}
		}
		
		firstHottest.printInfo();
		nextHottest.printInfo();
		
	}
	
	public void printColdestCities() {
		City firstColdest = null;
		City nextColdest = null;
		double coldestTemp = 0;
		
//		FIND FIRST COLDEST
	
		for(City curCity : cityList) {
			if(curCity.getLowTemp() < coldestTemp) {
				firstColdest = curCity;
				coldestTemp = curCity.getLowTemp();
			}
		}
		
		coldestTemp = 0;
		
//		FIND SECOND COLDEST 
		
		for(City curCity : cityList) {
			if(curCity.getLowTemp() < coldestTemp && (curCity != firstColdest)) {
				nextColdest = curCity;
				coldestTemp = curCity.getLowTemp();
			}
		}
		
		firstColdest.printInfo();
		nextColdest.printInfo();
	}
	
	public void printAllCities() {
		for(City curCity : cityList) {
			curCity.printInfo();
		}
	}
}

import java.io.*;
import java.util.Scanner;

class Main {
  static Scanner scnr = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    ClimateZone zone = new ClimateZone();

    int menuChoice = 0;

    while (menuChoice != 8) {
      displayMenu();
      menuChoice = getMenuChoice();

      if      (menuChoice == 1)
        zone = openDataFile();
      else if (menuChoice == 2)
        listAllCities(zone);
      else if (menuChoice == 3)
        listHottestCities(zone);
      else if (menuChoice == 4)
        listColdestCities(zone);
      else if (menuChoice == 5)
        addCity(zone);
      else if (menuChoice == 6)
        changeCityTemps(zone);
      else if (menuChoice == 7)
        countCities(zone);
      else if (menuChoice == 8)
        System.out.println("===== Quitting Program =====");
      else
        System.out.println("  !!! Invalid Menu Choice !!!");
    }
  }

  static void displayMenu() {
    System.out.println("===== Menu =====");
    System.out.println("1. Open a climate zone data file");
    System.out.println("2. List all cities");
    System.out.println("3. List hottest cities");
    System.out.println("4. List coldest cities");
    System.out.println("5. Add a city");
    System.out.println("6. Change a city's temperatures");
    System.out.println("7. Count cities");
    System.out.println("8. Quit program");
  }

  static int getMenuChoice() {
    System.out.print("Enter your menu Choice --> ");
    return scnr.nextInt();
  }

  static ClimateZone openDataFile() throws IOException {
    System.out.print("Enter data file name --> ");
    String fileName = scnr.next();

    return new ClimateZone(fileName);
  }

  static void listAllCities(ClimateZone zone) {
    System.out.println("===== All Cities =====");
    zone.printAllCities();
  }

  static void listHottestCities(ClimateZone zone) {
    System.out.println("===== Hottest Cities =====");
    zone.printHottestCities();
  }

  static void listColdestCities(ClimateZone zone) {
    System.out.println("===== Coldest Cities =====");
    zone.printColdestCities();
  }

  static void addCity(ClimateZone zone) {
    String cityName = getCityName();
    String stateName = getStateName();
    double highTemp = getHighTemp();
    double lowTemp = getLowTemp();

    zone.addCity(cityName, stateName, highTemp, lowTemp);
  }

  static void changeCityTemps(ClimateZone zone) {
    String cityName = getCityName();
    String stateName = getStateName();

    City cityToUpdate = zone.getCityByName(cityName, stateName);

    if (cityToUpdate != null) {
      double highTemp = getHighTemp();
      double lowTemp = getLowTemp();

      cityToUpdate.setHighTemp(highTemp);
      cityToUpdate.setLowTemp(lowTemp);
    } else {
      System.out.printf("  !!! No city with the name %s, %s found !!!\n", cityName, stateName);
    }
  }

  static void countCities(ClimateZone zone) {
    System.out.printf("There are %d cities in this data set.\n", zone.getCityCount());
  }

  static String getCityName() {
    System.out.print("Enter new city name  --> ");
    String cityName = scnr.next();
    
    return cityName;
  }
  static String getStateName() {
    System.out.print("Enter new state name  --> ");
    String stateName = scnr.next();
    
    return stateName;
  }

  static double getHighTemp() {
    System.out.print("Enter city's new high temperature --> ");
    return scnr.nextDouble();
  }

  static double getLowTemp() {
    System.out.print("Enter city's new low temperature -->");
    return scnr.nextDouble();
  }
}
