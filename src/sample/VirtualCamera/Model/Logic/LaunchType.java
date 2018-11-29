package sample.VirtualCamera.Model.Logic;

public class LaunchType {
    private static boolean firstProject;


    public static boolean isFirstProject() {
        return firstProject;
    }

    public static void setFirstProject(boolean firstProject) {
        LaunchType.firstProject = firstProject;
    }
}
