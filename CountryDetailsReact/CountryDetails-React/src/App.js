import './App.css';

    import React, { Component } from 'react';
    import Country from './countryComponent/country';

    class App extends Component {

    state = {
            countries: []
          }


 componentDidMount() {
              fetch('/countries/')
              .then(res => res.json())
              .then((data) => {
                this.setState({ countries: data })
              })
              .catch(console.log)
            }

      render() {
          return (
                    <Country countries={this.state.countries} />
                  );
      }
    }

    export default App;
