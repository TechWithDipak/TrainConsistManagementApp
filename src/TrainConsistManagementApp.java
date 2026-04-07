class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}
public class TrainConsistManagementApp {
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargoType) {
            try {

                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargoType.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargoType;
                System.out.println("Cargo assigned successfully -> " + cargoType);

            } catch (CargoSafetyException e) {
                System.err.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("===============================================\n");


        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        System.out.println();


        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}