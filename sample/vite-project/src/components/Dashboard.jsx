import React, { useState } from 'react';
import { useTable } from 'react-table';
import moment from 'moment';
import './Dashboard.css';
import Logo from '../assets/images/log01.png';
import { useSelector } from 'react-redux';
import DownloadIcon from '@mui/icons-material/Download';
import download from '../assets/images/download.jpeg';
import download1 from '../assets/images/download1.jpeg';
import download2 from '../assets/images/download2.jpeg';
import download3 from '../assets/images/download3.jpeg';

function Dashboard() {
    const name = useSelector((state) => state.name); // redux name

    const [data, setData] = useState([
        { name: 'HP', Mon: 'Code Review', Tue: 'Unit Testing', Wed: 'API Integration', Thu: 'Debugging', Fri: 'Code Refactoring', Sat: 'Documentation', Sun: 'Team Meeting' },
        { name: 'BALA', Mon: 'Client Meeting', Tue: 'Requirement Analysis', Wed: 'Design Mockup', Thu: 'Frontend Development', Fri: 'Backend Development', Sat: 'Code Review', Sun: 'Project Planning' },
        { name: 'ASWINBHARATH', Mon: 'Database Design', Tue: 'Schema Migration', Wed: 'API Development', Thu: 'Security Testing', Fri: 'Performance Optimization', Sat: 'Bug Fixing', Sun: 'Code Deployment' },
        { name: 'GOKUL', Mon: 'UI Design', Tue: 'User Testing', Wed: 'Accessibility Improvements', Thu: 'Cross-browser Testing', Fri: 'Responsive Design', Sat: 'UI Animation', Sun: 'Design Feedback' },
        { name: 'KATHIR', Mon: 'Sprint Planning', Tue: 'Task Assignment', Wed: 'Progress Tracking', Thu: 'Risk Management', Fri: 'Code Merge', Sat: 'Code Backup', Sun: 'Team Retrospective' },
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
        <>
            <div>
                <div className="new-container">
                    <navigation>
                        <ul>
                            <li><a href="/" className="new-logo new-link">
                                <img src={Logo} alt="Logo" />
                                <span className="new-nav-item">{name}</span>
                            </a></li>
                            <li><a href="#" className="new-link">
                                <i className="fas fa-menorah"></i>
                                <span className="new-nav-item">Dashboard</span>
                            </a></li>
                            <li><a href="#" className="new-link">
                                <i className="fas fa-comment"></i>
                                <span className="new-nav-item">Message</span>
                            </a></li>
                            <li><a href="#" className="new-link">
                                <i className="fas fa-database"></i>
                                <span className="new-nav-item">Report</span>
                            </a></li>
                            <li><a href="#" className="new-link">
                                <i className="fas fa-chart-bar"></i>
                                <span className="new-nav-item">Schedule</span>
                            </a></li>
                            <li><a href="#" className="new-link">
                                <i className="fas fa-cog"></i>
                                <span className="new-nav-item">Settings</span>
                            </a></li>
                            <li><a href="/" className="new-logout new-link">
                                <i className="fas fa-sign-out-alt"></i>
                                <span className="new-nav-item">Log out</span>
                            </a></li>
                        </ul>
                    </navigation>

                    <section className="new-main">
                        <div className="new-main-top">
                            <h1>Employees</h1>
                            <i className="fas fa-user-cog"></i>
                        </div>
                        <div className="new-users">
                            <div className="new-card">
                                <img src={download} alt="User" />
                                <h4>Hp</h4>
                                <p>Ui designer</p>
                                <div className="new-per">
                                    <table>
                                        <tr>
                                            <td><span>85%</span></td>
                                            <td><span>87%</span></td>
                                        </tr>
                                        <tr>
                                            <td>Month</td>
                                            <td>Year</td>
                                        </tr>
                                    </table>
                                </div>
                                <button>Profile</button>
                            </div>
                            <div className="new-card">
                                <img src={download1} alt="User" />
                                <h4>Bala</h4>
                                <p>Programmer</p>
                                <div className="new-per">
                                    <table>
                                        <tr>
                                            <td><span>82%</span></td>
                                            <td><span>85%</span></td>
                                        </tr>
                                        <tr>
                                            <td>Month</td>
                                            <td>Year</td>
                                        </tr>
                                    </table>
                                </div>
                                <button>Profile</button>
                            </div>
                            <div className="new-card">
                                <img src={download2} alt="User" />
                                <h4>Aswin Bharath</h4>
                                <p>Tester</p>
                                <div className="new-per">
                                    <table>
                                        <tr>
                                            <td><span>94%</span></td>
                                            <td><span>92%</span></td>
                                        </tr>
                                        <tr>
                                            <td>Month</td>
                                            <td>Year</td>
                                        </tr>
                                    </table>
                                </div>
                                <button>Profile</button>
                            </div>
                            <div className="new-card">
                                <img src={download3} alt="User" />
                                <h4>Gokul</h4>
                                <p>Ui designer</p>
                                <div className="new-per">
                                    <table>
                                        <tr>
                                            <td><span>85%</span></td>
                                            <td><span>82%</span></td>
                                        </tr>
                                        <tr>
                                            <td>Month</td>
                                            <td>Year</td>
                                        </tr>
                                    </table>
                                </div>
                                <button>Profile</button>
                            </div>
                        </div>
                        <div className="schedule-container">
                            <div className='headdddd'>
                            <h1>Schedule</h1>
                            </div>
                            <DownloadIcon className='download-icon' style={{ cursor: 'pointer' }} />
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
                    </section>
                </div>
            </div>
        </>
    )
}

export default Dashboard;
