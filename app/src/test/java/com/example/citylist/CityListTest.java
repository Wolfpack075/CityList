package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testdelete(){
        CityList cityList = new CityList();
        City city = new City("Bogura","Rajshahi");
        City city2 = new City("Kushtia","Khulna");

        cityList.add(city);
        cityList.add(city2);

        cityList.delete(city);
        assertFalse(cityList.getCities(1).contains(city));
        assertEquals(1,cityList.getCities(1).size());

    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testdeleteexception(){
        CityList cityList = new CityList();
        City city = new City("Manikgonj","Dhaka");
        City city2 = new City("Banderban","Chottogram");

        cityList.add(city);
        cityList.add(city2);

        assertEquals(2,cityList.count());

        cityList.delete(city);

        assertEquals(1,cityList.count());
        assertThrows(IllegalArgumentException.class ,()-> {
            cityList.delete(city);
        });

    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = new City("dummy1","hudai1");
        City city2 = new City("dummy2","hudai2");

        cityList.add(city);
        cityList.add(city2);

        cityList.count();
        assertEquals(2,cityList.getCities(1).size());


    }
    @Test
    public void testSortCities() {
        CityList cityList = new CityList();
        City city = new City("dumdum" , "Dubai");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));

        City city1 = new City("Abratown", "LaLaLand");
        cityList.add(city1);

        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city.compareTo(cityList.getCities(1).get(1)));
    }
}
