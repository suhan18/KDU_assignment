import MovieItem from "./MovieItem";
interface Movie {
  id: number;
  name: string;
  rating: number;
  watched: boolean;
}

interface Props {
  movies: Movie[];
  onToggleWatched: (id: number) => void;
  onDelete: (id: number) => void;
}

const MovieList = ({ movies, onToggleWatched, onDelete }: Props) => {
  return (
    <ul>
      {movies.map((movie) => (
        <MovieItem
          key={movie.id}
          movie={movie}
          onToggleWatched={onToggleWatched}
          onDelete={onDelete}
        />
      ))}
    </ul>
  );
};

export default MovieList;
