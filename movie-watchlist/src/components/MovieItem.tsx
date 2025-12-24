interface Movie {
  id: number;
  name: string;
  rating: number;
  watched: boolean;
}

interface Props {
  movie: Movie;
  onToggleWatched: (id: number) => void;
  onDelete: (id: number) => void;
}

const MovieItem = ({ movie, onToggleWatched, onDelete }: Props) => {
  return (
    <li className="movie">
      <div>
        <span
          style={{
            textDecoration: movie.watched ? "line-through" : "none",
          }}
        >
          {movie.name}
        </span>

        <div className="stars">{"⭐".repeat(movie.rating)}</div>
      </div>

      <button onClick={() => onToggleWatched(movie.id)}>
        {movie.watched ? "Watched" : "Not Watched"}
      </button>

      <button onClick={() => onDelete(movie.id)}>🗑</button>
    </li>
  );
};

export default MovieItem;
