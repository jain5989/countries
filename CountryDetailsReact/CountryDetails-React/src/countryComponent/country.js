import React from 'react'

    const country = ({ countries }) => {
          return (
            <div>
              <center><h1>Countries List</h1></center>
              <table>
              <tr>
              <td>
              <p> Country name </p>
              </td>
                <td>
                    <p> Country code </p>
                </td>
              </tr>
              {
              countries.map((countriesTest) => (
              <tr>
                  <td>
                    <h5 class="card-title">
                    <a href = "/">{countriesTest.name}</a></h5>
                  </td>
                    <td>
                       <h5 class="card-title">{countriesTest.countryCode}</h5>
                    </td>
                </tr>
              ))}
                  </table>
            </div>
          )
          };

    export default country