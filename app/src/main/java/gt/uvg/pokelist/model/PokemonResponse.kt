package gt.uvg.pokelist.model

data class PokemonResponse(
    val count: Int,
    val next: String,
    val previous: Any?,
    var results: List<Pokemon>
)