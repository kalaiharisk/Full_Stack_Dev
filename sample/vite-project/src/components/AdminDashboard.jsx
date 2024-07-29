import React, { useState } from 'react';
import { useTable } from 'react-table';
import moment from 'moment';
import './AdminDashboard.css';
import './Dashboard.css';
import Logo from '../assets/images/log01.png';
import { useSelector } from 'react-redux';
import DownloadIcon from '@mui/icons-material/Download';

function AdminDashboard() {
    const name = useSelector((state) => state.name); // redux name

    const [data, setData] = useState([
        { name: 'HP', role: 'Developer', image: 'https://via.placeholder.com/70', Mon: 'Code Review', Tue: 'Unit Testing', Wed: 'API Integration', Thu: 'Debugging', Fri: 'Code Refactoring', Sat: 'Documentation', Sun: 'Team Meeting' },
        { name: 'BALA', role: 'Developer', image: 'https://via.placeholder.com/70', Mon: 'Client Meeting', Tue: 'Requirement Analysis', Wed: 'Design Mockup', Thu: 'Frontend Development', Fri: 'Backend Development', Sat: 'Code Review', Sun: 'Project Planning' },
        { name: 'ASWINBHARATH', role: 'Developer', image: 'https://via.placeholder.com/70', Mon: 'Database Design', Tue: 'Schema Migration', Wed: 'API Development', Thu: 'Security Testing', Fri: 'Performance Optimization', Sat: 'Bug Fixing', Sun: 'Code Deployment' },
        { name: 'GOKUL', role: 'Developer', image: 'https://via.placeholder.com/70', Mon: 'UI Design', Tue: 'User Testing', Wed: 'Accessibility Improvements', Thu: 'Cross-browser Testing', Fri: 'Responsive Design', Sat: 'UI Animation', Sun: 'Design Feedback' },
        { name: 'KATHIR', role: 'Developer', image: 'https://via.placeholder.com/70', Mon: 'Sprint Planning', Tue: 'Task Assignment', Wed: 'Progress Tracking', Thu: 'Risk Management', Fri: 'Code Merge', Sat: 'Code Backup', Sun: 'Team Retrospective' },
    ]);

    const [newEmployee, setNewEmployee] = useState('');
    const [showModal, setShowModal] = useState(false);
    const [currentEmployeeIndex, setCurrentEmployeeIndex] = useState(null);

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

    const handleAddEmployee = () => {
        if (!newEmployee) return; // Prevent adding empty names
        const newEmp = { name: newEmployee, role: 'New Role', image: 'https://via.placeholder.com/70', Mon: '', Tue: '', Wed: '', Thu: '', Fri: '', Sat: '', Sun: '' };
        setData([...data, newEmp]);
        setNewEmployee('');
    };

    const handleEditEmployee = (index) => {
        setCurrentEmployeeIndex(index);
        setShowModal(true);
    };

    const handleSaveEmployee = () => {
        if (currentEmployeeIndex === null) return;
        const updatedData = data.map((emp, index) =>
            index === currentEmployeeIndex ? data[currentEmployeeIndex] : emp
        );
        setData(updatedData);
        setShowModal(false);
    };

    const handleModalInputChange = (e, field) => {
        if (currentEmployeeIndex !== null) {
            const updatedEmployee = { ...data[currentEmployeeIndex], [field]: e.target.value };
            setData(prevData =>
                prevData.map((emp, index) =>
                    index === currentEmployeeIndex ? updatedEmployee : emp
                )
            );
        }
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
                            <li><a href="#" className="-newlink">
                                <i className="fas fa-comment"></i>
                                <span className="-new-nav-item">Message</span>
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
                            <li><a href="/" className="new-logout-link link">
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

                        <div className="manage-users">
                            <div className="add-employee">
                                <input
                                    type="text"
                                    value={newEmployee}
                                    onChange={(e) => setNewEmployee(e.target.value)}
                                    placeholder="Enter new employee name"
                                />
                                <button onClick={handleAddEmployee}>Add Employee</button>
                            </div>

                            <div className="employee-list">
                                {data.map((employee, index) => (
                                    <div key={index} className="employee-card">
                                        <img src={employee.image} alt="User" className='employee-image'/>
                                        <div className="emp-details">
                                            <h4>{employee.name}</h4>
                                            <p>{employee.role}</p>
                                        </div>
                                        <button onClick={() => handleEditEmployee(index)}>Edit Profile</button>
                                    </div>
                                ))}
                            </div>
                        </div>

                        <div className="schedule-container">
                            <h1>Schedule</h1>
                            <DownloadIcon className="download-icon" />
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

                {showModal && (
                    <div className="modal">
                        <div className="modal-content">
                            <h2>Edit Employee</h2>
                            <label>Name:</label>
                            <input
                                type="text"
                                value={data[currentEmployeeIndex]?.name || ''}
                                onChange={(e) => handleModalInputChange(e, 'name')}
                            />
                            <label>Role:</label>
                            <input
                                type="text"
                                value={data[currentEmployeeIndex]?.role || ''}
                                onChange={(e) => handleModalInputChange(e, 'role')}
                            />
                            <label>Image URL:</label>
                            <input
                                type="text"
                                value={data[currentEmployeeIndex]?.image || ''}
                                onChange={(e) => handleModalInputChange(e, 'image')}
                            />
                            <button onClick={handleSaveEmployee}>Save</button>
                            <button onClick={() => setShowModal(false)}>Cancel</button>
                        </div>
                    </div>
                )}
            </div>
        </>
    );
}

export default AdminDashboard;
