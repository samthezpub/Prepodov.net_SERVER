import "./App.css";
import "@material/web/button/filled-button.js";
import "@material/web/button/outlined-button.js";
import "@material/web/checkbox/checkbox.js";

function App() {
  return (
    <div className="App">
      <script type="module" src="./index.js"></script>

      <label>
        Material 3<md-checkbox checked></md-checkbox>
      </label>

      <md-outlined-button>Back</md-outlined-button>
      <md-filled-button>Next</md-filled-button>
    </div>
  );
}

export default App;
