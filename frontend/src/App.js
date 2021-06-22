// import logo from './logo.svg';
import './App.css';



const getFactorial = async (e) => {
    const num = document.querySelector("input").value;
    const url = `http://localhost:8080/api/factorial?input=${num}`;
    const res = await fetch(url);
    const ans = await res.text();
    const message = document.querySelector("#answer");
    message.textContent = `${num}! = ${ans}`;
}


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
          <button onClick={getFactorial}>Get Factorial</button>
          <p id="answer"></p>
      </div>
    </div>
  );

}


export default App;
