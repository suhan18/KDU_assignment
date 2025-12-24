import { useState } from "react";
import AddMovie from "./AddMovie";
import MovieList from "./MovieList";

interface Movie {
  id: number;
  name: string;
  rating: number;
  watched: boolean;
}

const Watchlist = () => {
  const [movies, setMovies] = useState<Movie[]>([]);
  const [search, setSearch] = useState("");

  const addMovie = (name: string, rating: number) => {
    if (name.trim() === "") {
      alert("Movie name cannot be empty");
      return;
    }

    const duplicate = movies.some(
      (m) => m.name.toLowerCase() === name.toLowerCase()
    );

    if (duplicate) {
      alert("Movie already exists in watchlist");
      return;
    }

    setMovies([
      ...movies,
      {
        id: Date.now(),
        name,
        rating,
        watched: false,
      },
    ]);
  };

  const toggleWatched = (id: number) => {
    setMovies(
      movies.map((movie) =>
        movie.id === id ? { ...movie, watched: !movie.watched } : movie
      )
    );
  };

  const deleteMovie = (id: number) => {
    setMovies(movies.filter((movie) => movie.id !== id));
  };

  const clearAll = () => {
    setMovies([]);
  };

  const filteredMovies = movies.filter((movie) =>
    movie.name.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="container">
      <h1>🎬 Movie Watchlist</h1>

      <AddMovie onAdd={addMovie} />

      <input
        type="text"
        placeholder="Search movies..."
        onChange={(e) => setSearch(e.target.value)}
      />

      <div className="header">
        <span>Movies in Watchlist: {filteredMovies.length}</span>
        {movies.length > 0 && <button onClick={clearAll}>Clear All</button>}
      </div>

      {filteredMovies.length === 0 ? (
        <p className="empty">Your watchlist is empty. Add your first movie!</p>
      ) : (
        <MovieList
          movies={filteredMovies}
          onToggleWatched={toggleWatched}
          onDelete={deleteMovie}
        />
      )}
    </div>
  );
};

export default Watchlist;
