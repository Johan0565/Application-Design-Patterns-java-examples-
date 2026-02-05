class DryShawarma extends ShawarmaTemplate {
    @Override
    protected void addMainFilling() {
        System.out.println("2. Кладем только мясо.");
    }

    @Override
    protected void addVegetables() {
        System.out.println("3. Немного лука.");
    }

    @Override
    protected void addSauce() {

    }

    @Override
    protected boolean customerWantsSauce() {
        return false; // Соус не нужен
    }
}
