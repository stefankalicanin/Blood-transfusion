import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ViewProfile from "./Pages/ViewProfile";


function App() {
  return (
    <div className="App">

        <Router>
            <ViewProfile />
              </Router>

    </div>
  );
}

export default App;
