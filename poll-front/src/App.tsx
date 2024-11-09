
import './App.css'

import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CreatePollForm from './Components/CreatePollForm/PollCreateForm';

function App () {

  return (
    <Router>
      <Routes>
      <Route path="/" element={<CreatePollForm/>} />
      </Routes>
    </Router>
  )
}

export default App
