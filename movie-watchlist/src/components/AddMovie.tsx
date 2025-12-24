import { useState } from "react";

interface Props {
  onAdd: (name: string, rating: number) => void;
}

const AddMovie = ({ onAdd }: Props) => {
  const [name, setName] = useState("");
  const [rating, setRating] = useState(5);

  return (
    <div className="card">
      <input
        type="text"
        placeholder="Enter movie name..."
        value={name}
        onChange={(e) => setName(e.target.value)}
      />

      <select
        value={rating}
        onChange={(e) => setRating(Number(e.target.value))}
      >
        {[1, 2, 3, 4, 5].map((r) => (
          <option key={r} value={r}>
            {"⭐".repeat(r)}
          </option>
        ))}
      </select>

      <button
        onClick={() => {
          onAdd(name, rating);
          setName("");
          setRating(5);
        }}
      >
        + Add to Watchlist
      </button>
    </div>
  );
};

export default AddMovie;
