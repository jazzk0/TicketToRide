package model;

public class Edge
{
    private static int numberOfAllEdges = 0;
    private static int weightOfAllEdges = 0;

    private City source;
    private City destination;
    private GameColor routeColor;
    private int weight;
    private TeamColor teamColor;
    private boolean visited;

    // ============================== class ==============================

    public Edge(City source, City destination, GameColor routeColor, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.routeColor = routeColor;
        teamColor = null;
        this.visited = false;

        ++numberOfAllEdges;
        weightOfAllEdges += weight;
    }

    // ============================== other ==============================

    public void claimRoute(TeamColor teamColor) throws UnsupportedOperationException
    {
        if (this.teamColor != null) throw new UnsupportedOperationException();

        this.teamColor = teamColor;
    }

    @Override
    public String toString()
    {
        String sourceString = this.source.toString();
        String destinationString = this.destination.toString();
        String routeColorString = this.routeColor.toString();
        String weightString = Integer.toString(weight);

        return (sourceString + " " + destinationString + " " + routeColorString + " " + weightString);
    }

    // ============================== getters ==============================

    public City getSource() { return this.source; }

    public City getDestination() { return this.destination; }

    @SuppressWarnings("WeakerAccess")
    public static int getWeightOfAllEdges() { return weightOfAllEdges; }

    @SuppressWarnings("WeakerAccess")
    public static int getNumberOfAllEdges() { return numberOfAllEdges; }

    @SuppressWarnings("WeakerAccess")
    public int getWeight() { return this.weight; }

    public boolean getVisited() { return this.visited; }

    public TeamColor getTeamColor() { return this.teamColor; }

    @SuppressWarnings("WeakerAccess")
    public GameColor getRouteColor() { return this.routeColor; }

    // ============================== setters ==============================

    @SuppressWarnings("WeakerAccess")
    public static void setWeightOfAllEdges(int weight) throws ArithmeticException
    {
        if (weight <= 0) throw new ArithmeticException();
        weightOfAllEdges = weight;
    }

    @SuppressWarnings("WeakerAccess")
    public static void setNumberOfAllEdges(int number) throws ArithmeticException
    {
        if (number <= 0) throw new ArithmeticException();
        numberOfAllEdges = number;
    }

    public void setSource(City source) { this.source = source; }

    public void setDestination(City destination) { this.destination = destination; }

    public void setWeight(int weight) throws IllegalArgumentException
    {
        if (weight <= 0) throw new IllegalArgumentException();

        weightOfAllEdges -= this.weight;
        weightOfAllEdges += weight;
    }

    public void setRouteColor(GameColor routeColor) { this.routeColor = routeColor; }

    public void setTeamColor(TeamColor teamColor) { this.teamColor = teamColor; }

    public void setVisited(boolean visited) { this.visited = visited; }
}