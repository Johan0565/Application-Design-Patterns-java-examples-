class MeatShawarma extends ShawarmaTemplate {
    @Override
    protected void addMainFilling() {
        System.out.println("2. Кладем сочную курицу с вертела.");
    }

    @Override
    protected void addVegetables() {
        System.out.println("3. Добавляем капусту, огурцы и помидоры.");
    }

    @Override
    protected void addSauce() {
        System.out.println("4. Поливаем чесночным соусом.");
    }
}
