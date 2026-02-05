class XmlExportVisitor implements Visitor {
    @Override
    public void visit(Shawarma shawarma) {
        System.out.println("<shawarma>");
        System.out.println("    <name>" + shawarma.getName() + "</name>");
        System.out.println("    <cal>" + shawarma.getCalories() + "</cal>");
        System.out.println("</shawarma>");
    }

    @Override
    public void visit(Drink drink) {
        System.out.println("<drink>");
        System.out.println("    <name>" + drink.getName() + "</name>");
        System.out.println("    <total_cal>" + drink.getTotalCalories() + "</total_cal>");
        System.out.println("</drink>");
    }
}
