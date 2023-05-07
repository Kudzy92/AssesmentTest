package app.kudzy.service;

public interface ResistanceCalService {
    void message(String msg,String option);
 String readInput();
    void printLine();
    void printDottedLine();
    Double performResistanceCal(String circuitType, String resVarStr);

    Boolean checkValidity(String resValueStr);

    String resValueStrListToReadable(String strIn);
    int getResistorsNumber(String strIn);
    String resWorkings(String circuitType,String strIn);
    void setCiruitType(String strIn);
    void mainServiceRunner();
}
