import './App.css';



const getFactorial = async (e) => {
    const num = document.querySelector("input").value;
    if (num === "") {
        return;
    }
    const url = `http://localhost:8080/api/factorial?input=${num}`;
    const message = document.querySelector("#answer");
    let res;
    res = await fetch(url);
    const ans = await res.text();
    if (res.status === 200) {
        message.textContent = `${num}! = ${ans}`;
        message.style.fontSize = "2em";
    } else {
        message.textContent = ans;
        message.style.fontSize = "1em";
    }

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
                <p id="answer" data-testid="answer">&nbsp;</p>
            </div>
        </div>
    );

}


export default App;
