# TP2-TESTAUTOMATIQUE

Pour le cours MGL7460, automne 2016.

LocationsList lst = new LocationsList();
        lst.addvehiculelist(new Vehicule("78959111","Toyota","Camry","Sedan","2016","120",Etatvoiture.Disponile));
        lst.addvehiculelist(new Vehicule("20162222","Honda","Accord","SEDAN","2016","120", Etatvoiture.Disponile));
        lst.addvehiculelist(new Vehicule("20162010","gip","Accord","SEDAN","2016","120", Etatvoiture.Disponile));

        lst.addvehiculelist(new Vehicule("78959333","Toyota","Camry","Sedan","2016","120",Etatvoiture.Louer));
        lst.addvehiculelist(new Vehicule("20162444","Honda","Accord","SEDAN","2016","120", Etatvoiture.Louer));
        lst.addvehiculelist(new Vehicule("20162555","gip","Accord","SEDAN","2016","120", Etatvoiture.Louer));
        LocationsList s =locationListRepository.save(lst);