package pockmonproject;

class PokemonBSTNode {

    private Pockmon pokemon;
    private PokemonBSTNode left;
    private PokemonBSTNode right;

    public PokemonBSTNode(Pockmon pokemon) {
        this.pokemon = pokemon;
        this.left = null;
        this.right = null;
    }

    public Pockmon getPokemon() {
        return pokemon;
    }
   
    public void setPokemon(Pockmon pokemon) {
        this.pokemon = pokemon;
    }

    public PokemonBSTNode getLeft() {
        return left;
    }

    public void setLeft(PokemonBSTNode left) {
        this.left = left;
    }

    public PokemonBSTNode getRight() {
        return right;
    }

    public void setRight(PokemonBSTNode right) {
        this.right = right;
    }

}
