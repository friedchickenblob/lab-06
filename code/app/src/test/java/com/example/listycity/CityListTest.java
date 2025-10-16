package com.example.listycity;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;


public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();

        City mockCity = mockCity();
        assertEquals(true, cityList.hasCity(mockCity));

//        System.out.println(cityList);
        for (City c : cityList.getCities()) {
            System.out.println(c.getCityName());
        }
        try {
            cityList.delete(mockCity);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

        for (City c : cityList.getCities()) {
            System.out.println(c.getCityName());
        }

        assertEquals(false, cityList.hasCity(mockCity));

        Exception thrown = assertThrows(Exception.class, () -> {
            cityList.delete(mockCity);
        });

        Assertions.assertEquals("city not in list", thrown.getMessage());


        assertEquals(0, cityList.getCities().size());
    }

    //1) Implement and test these methods: - hasCity(City city) - When given a city, return whether or not it belongs in the list
//
//- Test to see whether your method is correct (Read https://www.infoworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html) delete(City city)
//
//- Check if a city is present in the list. If it does t
// 
// When remove it from the list, if not then **throw an exception**
//
//- Test to see if your method actually removes it from the list
//
//- Test to see if the exception is actually thrown (Read more here https://howtodoinjava.com/junit5/expected-exception-example/) countCities()
//
//- Return how many cities are in the list
//
//-  Test to see whether your method is correct
}
