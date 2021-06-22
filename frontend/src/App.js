// import logo from './logo.svg';
import './App.css';

function App() {


  return (
    <div className="App">
      <header className="App-header">
        <div className="App-logo">
            <h1>n !</h1>
        </div>
        <p>
          Factorial
        </p>
      </header>
      <div className="App-body">
          <input type="text" className="number" placeholder="Enter a number" />
          <button>Get Factorial</button>
      </div>
    </div>
  );
}

export default App;
