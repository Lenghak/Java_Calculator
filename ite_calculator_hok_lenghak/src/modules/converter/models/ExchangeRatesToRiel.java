package modules.converter.models;

public enum ExchangeRatesToRiel {
    
    FROM_USD(4068.96),
    FROM_FRANC(4230.75),
    FROM_EURO(4361.52),
    FROM_POUND_STERLING(5081.51),
    FROM_BAHT(1118.65);

    final double value;

    ExchangeRatesToRiel(double v) {
        this.value = v;
    }

}
