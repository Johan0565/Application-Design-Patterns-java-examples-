class CryptoAdapter implements PaymentProcessor {
    private CryptoLibrary cryptoLibrary;

    private static final double RUB_TO_BTC_RATE = 0.00000025;
    private static final String COMPANY_WALLET = "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa";

    public CryptoAdapter(CryptoLibrary cryptoLibrary) {
        this.cryptoLibrary = cryptoLibrary;
    }

    @Override
    public void pay(double rubles){
        double btcAmount = rubles * RUB_TO_BTC_RATE;

        System.out.println("\n[Adapter] Конвертация " + rubles + " руб. -> " + btcAmount + " BTC");

        cryptoLibrary.sendBitcoin(COMPANY_WALLET, btcAmount);
    }
}
