package test.revolut.balancer;


public class Provider {
    private final String name;

    public Provider(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null)
            return false;
        if (obj instanceof Provider) {
            Provider provider = (Provider) obj;
            return provider.name.equals(name);
        }
        return false;
    }
}
