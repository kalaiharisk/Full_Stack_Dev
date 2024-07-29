import React, { useState } from 'react';
import { useTable } from 'react-table';
import moment from 'moment';
import '../assets/Pro.css';

const Schedule = () => {
  const [data, setData] = useState([
    { name: 'Kathir', Mon: '', Tue: '', Wed: '', Thu: '', Fri: '', Sat: '', Sun: '' },
    { name: 'Bala', Mon: '', Tue: '', Wed: '', Thu: '', Fri: '', Sat: '', Sun: '' },
    { name: 'Aswin', Mon: '', Tue: '', Wed: '', Thu: '', Fri: '', Sat: '', Sun: '' },
    { name: 'Gokul', Mon: '', Tue: '', Wed: '', Thu: '', Fri: '', Sat: '', Sun: '' },
    { name: 'Hari', Mon: '', Tue: '', Wed: '', Thu: '', Fri: '', Sat: '', Sun: '' },
  ]);

  const handleInputChange = (rowIndex, columnId, value) => {
    setData(oldData => 
      oldData.map((row, index) => {
        if (index === rowIndex) {
          return {
            ...oldData[rowIndex],
            [columnId]: value,
          };
        }
        return row;
      })
    );
  };

  const columns = React.useMemo(
    () => [
      { Header: 'Name', accessor: 'name' },
      { Header: moment().startOf('week').format('ddd. MMM D'), accessor: 'Mon' },
      { Header: moment().startOf('week').add(1, 'day').format('ddd. MMM D'), accessor: 'Tue' },
      { Header: moment().startOf('week').add(2, 'day').format('ddd. MMM D'), accessor: 'Wed' },
      { Header: moment().startOf('week').add(3, 'day').format('ddd. MMM D'), accessor: 'Thu' },
      { Header: moment().startOf('week').add(4, 'day').format('ddd. MMM D'), accessor: 'Fri' },
      { Header: moment().startOf('week').add(5, 'day').format('ddd. MMM D'), accessor: 'Sat' },
      { Header: moment().startOf('week').add(6, 'day').format('ddd. MMM D'), accessor: 'Sun' },
    ],
    []
  );

  const { getTableProps, getTableBodyProps, headerGroups, rows, prepareRow } = useTable({
    columns,
    data,
  });

  return (
    <div className="schedule-container">
      <h1>Schedule</h1>
      <table {...getTableProps()} className="schedule-table">
        <thead>
          {headerGroups.map(headerGroup => (
            <tr {...headerGroup.getHeaderGroupProps()}>
              {headerGroup.headers.map(column => (
                <th {...column.getHeaderProps()}>{column.render('Header')}</th>
              ))}
            </tr>
          ))}
        </thead>
        <tbody {...getTableBodyProps()}>
          {rows.map((row, i) => {
            prepareRow(row);
            return (
              <tr {...row.getRowProps()}>
                {row.cells.map(cell => {
                  return (
                    <td {...cell.getCellProps()}>
                      {cell.column.id === 'name' ? (
                        cell.render('Cell')
                      ) : (
                        <input
                          value={cell.value}
                          onChange={e => handleInputChange(i, cell.column.id, e.target.value)}
                        />
                      )}
                    </td>
                  );
                })}
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default Schedule;
