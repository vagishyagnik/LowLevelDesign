package DesignPatterns.BuilderPattern;

public class Computer {
    private String ssd;
    private String ram;
    private boolean isGraphicCardEnabled;
    private boolean isBluetoothEnabled;

    public String getSsd() {
        return ssd;
    }

    public String getRam() {
        return ram;
    }

    public boolean isGraphicCardEnabled() {
        return isGraphicCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public static class ComputerBuilder {
        private String ssd;
        private String ram;
        private boolean isGraphicCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder ssd(String ssd) {
            this.ssd = ssd;
            return this;
        }
        public ComputerBuilder ram(String ram) {
            this.ram = ram;
            return this;
        }
        public ComputerBuilder graphicCard(boolean isGraphicCardEnabled) {
            this.isGraphicCardEnabled = isGraphicCardEnabled;
            return this;
        }
        public ComputerBuilder bluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }
        public Computer build() {
            Computer computer = new Computer();
            computer.ram = this.ram;
            computer.ssd = this.ssd;
            computer.isBluetoothEnabled = this.isBluetoothEnabled;
            computer.isGraphicCardEnabled = this.isGraphicCardEnabled;
            return computer;
        }
    }
}
