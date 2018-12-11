package write;

public interface Writer {

    /**
     * Starts writing process
     */
    void start();

    /**
     * Writes on line
     * @param line
     */
    void writeLine(String line);

    /**
     * Stops writing process
     */
    void stop();
}
