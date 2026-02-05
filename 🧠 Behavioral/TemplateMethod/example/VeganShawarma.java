class VeganShawarma extends ShawarmaTemplate {
    @Override
    protected void addMainFilling() {
        System.out.println("2. Кладем фалафель и хумус.");
    }

    @Override
    protected void addVegetables() {
        System.out.println("3. Добавляем много салата айсберг.");
    }

    @Override
    protected void addSauce() {
        System.out.println("4. Поливаем оливковым маслом.");
    }
}
